package com.example.bigstepassignmentapp.ui.main.view.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bigstepassignmentapp.R
import com.example.bigstepassignmentapp.data.model.Video
import com.example.bigstepassignmentapp.databinding.FragmentHistoryBinding
import com.example.bigstepassignmentapp.databinding.FragmentVideosBinding
import com.example.bigstepassignmentapp.ui.main.adapter.VideoRecyclerAdapter
import com.example.bigstepassignmentapp.ui.main.viewmodel.VideosViewModel
import com.example.bigstepassignmentapp.utils.Status


/**
 * A placeholder fragment containing a simple view.
 */
class VideosFragment : Fragment() {

    private lateinit var binding: FragmentVideosBinding
    private var viewModel: VideosViewModel? = null
    private lateinit var adapter: VideoRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_videos,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = VideoRecyclerAdapter(onItemClick = ::onItemClick)
        binding.recyclerViewVideo.adapter = adapter
        viewModel = (activity as TabbedActivity).videoViewModel

        observeData()
    }

    private fun onItemClick(video: Video){
        viewModel?.insertVideo(video)
    }

    private fun observeData() {
        viewModel?.videoResponse?.observe(requireActivity(), Observer {
            when (it.status) {
                Status.ERROR -> {

                }

                Status.LOADING -> {

                }

                Status.SUCCESS -> {
                    adapter.setVideoList(it.data?.results!!)
                }
            }
        })
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): VideosFragment {
            return VideosFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}