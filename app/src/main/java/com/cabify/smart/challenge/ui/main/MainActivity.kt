package com.cabify.smart.challenge.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cabify.smart.challenge.R
import com.cabify.smart.challenge.base.BaseActivity
import com.cabify.smart.challenge.di.activity.ActivityComponent
import com.cabify.smart.challenge.ui.model.ProductView
import kotlinx.android.synthetic.main.item_product.view.*

class MainActivity : BaseActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)

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

    inner class ProductAdapter(): RecyclerView.Adapter<ProductAdapter.ProductHolder>() {
        private var productList: List<ProductView> = mutableListOf()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ProductHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false))

        override fun getItemCount() = productList.size

        override fun onBindViewHolder(holder: ProductHolder, position: Int) = holder.bin(productList[position])

        fun replaceData(productList: List<ProductView>) {
            this.productList = productList
            notifyDataSetChanged()
        }

        inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bin(productView: ProductView){
                productView.run {

                    itemView.product.text = productView.name
                    itemView.crew_race.text = race.name

                }
            }
        }
    }
}
