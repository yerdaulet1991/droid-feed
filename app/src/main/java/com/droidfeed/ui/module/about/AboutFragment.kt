package com.droidfeed.ui.module.about

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.droidfeed.databinding.FragmentAboutBinding
import com.droidfeed.ui.adapter.UiModelAdapter
import com.nytclient.ui.common.BaseFragment
import javax.inject.Inject

/**
 * Created by Dogan Gulcan on 11/5/17.
 */
class AboutFragment : BaseFragment() {

    private lateinit var binding: FragmentAboutBinding
    private lateinit var viewModel: AboutViewModel
    @Inject lateinit var adapter: UiModelAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AboutViewModel::class.java)

        binding.viewModel = viewModel
        binding.onClickListener = viewModel.aboutScreenClickListener

        init()
        initObservers()
    }

    private fun init() {
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = adapter
    }

    private fun initObservers() {
        viewModel.licenceUiModels.observe(this, Observer {
            adapter.addUiModels(it)
        })

        viewModel.rateAppEvent.observe(this, Observer {
            if (it?.resolveActivity(activity.packageManager) != null) {
                startActivity(it)
            }
        })

        viewModel.contactDevEvent.observe(this, Observer {
            if (it?.resolveActivity(activity.packageManager) != null) {
                startActivity(it)
            }
        })

        viewModel.shareAppEvent.observe(this, Observer {
            if (it?.resolveActivity(activity.packageManager) != null) {
                startActivity(it)
            }
        })
    }


}