package com.cabify.smart.challenge.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cabify.smart.challenge.R
import com.cabify.smart.challenge.base.BaseActivity
import com.cabify.smart.challenge.di.activity.ActivityComponent
import com.cabify.smart.challenge.domain.model.Product
import com.cabify.smart.challenge.domain.model.ProductCheckOut
import com.cabify.smart.challenge.domain.model.mapper.Mapper
import com.cabify.smart.challenge.ui.data.ResourceState
import com.cabify.smart.challenge.ui.model.ProductView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_product.view.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    private val productAdapter = ProductAdapter()
    private val productCheckoutAdapter = ProductCheckoutAdapter()

    private lateinit var mainActivityViewModel: MainActivityViewModel

    @Inject
    private lateinit var productMapper: Mapper<Product, ProductView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        productAdapter.addProductListener =
                { product -> mainActivityViewModel.addProductToCheckout(product.code) }
        productCheckoutAdapter.removeProductListener =
                { product -> mainActivityViewModel.removeProductToCheckout(product.code) }

        mainActivityViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)

        setListener()

        mainActivityViewModel.getProducts()
    }

    private fun setListener() {
        mainActivityViewModel.getProductsLiveData.observe(this, Observer { resource ->
            resource?.run {
                managementResourceState(status, message)
                if (status == ResourceState.SUCCESS) {
                    data?.run {
                        productAdapter.replaceData(this)
                    }
                }
            }
        })

        mainActivityViewModel.checkoutProductsLiveData.observe(this, Observer { resource ->
            resource?.run {
                managementResourceState(status, message)
                if (status == ResourceState.SUCCESS) {
                    data?.run {
                        total_amount.text = "${sumBy { it.price }}"
                        productCheckoutAdapter.replaceData(this)
                    }
                }
            }
        })

    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun checkAgain(): () -> Unit {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun tryAgain(): () -> Unit {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    inner class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {
        var addProductListener: ((product: Product) -> Unit)? = null

        private var productList: List<ProductView> = mutableListOf()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ProductHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false))

        override fun getItemCount() = productList.size

        override fun onBindViewHolder(holder: ProductHolder, position: Int) = holder.bin(productList[position])

        fun replaceData(productList: List<ProductView>) {
            this.productList = productList
            notifyDataSetChanged()
        }

        inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bin(product: ProductView) {
                product.run {
                    itemView.product.text = name
                    itemView.price.text = price
                    itemView.add_product.setOnClickListener {
                        addProductListener?.run {
                            invoke()
                        }
                    }
                }
            }
        }
    }

    inner class ProductCheckoutAdapter : RecyclerView.Adapter<ProductCheckoutAdapter.ProductCheckoutHolder>() {
        var removeProductListener: ((productCheckOut: ProductCheckOut) -> Unit)? = null

        private var productList: List<ProductCheckOut> = mutableListOf()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ProductCheckoutHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false))

        override fun getItemCount() = productList.size

        override fun onBindViewHolder(holder: ProductCheckoutHolder, position: Int) = holder.bin(productList[position])

        fun replaceData(productList: List<ProductCheckOut>) {
            this.productList = productList
            notifyDataSetChanged()
        }

        inner class ProductCheckoutHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bin(productCheckOut: ProductCheckOut) {
                productCheckOut.run {
                    itemView.product.text = name
                    itemView.price.text = price
                    itemView.add_product.setOnClickListener {
                        removeProductListener?.run {
                            invoke()
                        }
                    }
                }
            }
        }
    }
}
