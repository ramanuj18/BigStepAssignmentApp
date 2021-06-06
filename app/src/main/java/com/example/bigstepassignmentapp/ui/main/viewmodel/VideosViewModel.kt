package com.example.bigstepassignmentapp.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bigstepassignmentapp.data.model.ApiResponse
import com.example.bigstepassignmentapp.data.model.Video
import com.example.bigstepassignmentapp.data.repository.VideoRepository
import com.example.bigstepassignmentapp.utils.NetworkHelper
import com.example.bigstepassignmentapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideosViewModel @Inject constructor(
    private val videoRepository: VideoRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _videoResponse = MutableLiveData<Resource<ApiResponse>>()
    val videoResponse: LiveData<Resource<ApiResponse>>
        get() = _videoResponse

    val videoHistoryLiveData = videoRepository.getVideoHistory()

    fun insertVideo(video: Video) = videoRepository.insertVideo(video)

    fun deleteVideo(video: Video) = videoRepository.deleteVideo(video)

    fun fetchVideos() {
        viewModelScope.launch {
            _videoResponse.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                videoRepository.getVideos().let {
                    if (it.isSuccessful) {
                        _videoResponse.postValue(Resource.success(it.body()))
                    } else _videoResponse.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _videoResponse.postValue(Resource.error("No internet connection", null))
        }
    }
}