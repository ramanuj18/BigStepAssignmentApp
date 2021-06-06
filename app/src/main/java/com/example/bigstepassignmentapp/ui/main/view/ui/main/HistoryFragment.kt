package com.example.bigstepassignmentapp.ui.main.view.ui.main

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
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
import com.example.bigstepassignmentapp.ui.main.adapter.VideoRecyclerAdapter
import com.example.bigstepassignmentapp.ui.main.viewmodel.VideosViewModel


/**
 * A placeholder fragment containing a simple view.
 */
class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private var viewModel: VideosViewModel? = null
    private lateinit var adapter: VideoRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_history,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = VideoRecyclerAdapter(onClick = ::onItemClick)
        binding.recyclerViewVideo.adapter = adapter
        viewModel = (activity as TabbedActivity).videoViewModel

        observeData()
    }
    //event, 1 for click event and 2 for long click event
    private fun onItemClick(video:Video, event: Int){
        when(event){
            1->{
                val intent = Intent(requireContext(), DetailActivity::class.java)
                intent.putExtra("video",video)
                startActivity(intent)
            }
            2->{
                deleteAlertDialog(video)
            }
        }
    }

    private fun deleteAlertDialog(video: Video){
        AlertDialog.Builder(requireContext()).setMessage("Are you want to delete this video from history?")
            .setPositiveButton("Yes"
            ) { dialog, which ->
                viewModel?.deleteVideo(video)
            }
            .setNegativeButton("No",null)
            .show()
    }

    private fun observeData() {
        viewModel?.videoHistoryLiveData?.observe(requireActivity(), Observer {
            adapter.setVideoList(it)
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
        fun newInstance(sectionNumber: Int): HistoryFragment {
            return HistoryFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}