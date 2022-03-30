package com.narendra.newsapplication.news_list

import com.narendra.comman.model.Resource
import com.narendra.news_domain.use_case.NewsUseCase
import com.narendra.newsapplication.BaseViewModelTest
import com.narendra.newsapplication.getDummyNewsData
import com.narendra.newsapplication.runBlockingMainTest

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class NewsListViewModelTest : BaseViewModelTest() {

    @Mock
    private lateinit var newsUseCaseTemp: NewsUseCase
    private lateinit var newsListViewModel: NewsListViewModel

    @Before
    fun setUp() {
        newsListViewModel = NewsListViewModel(newsUseCaseTemp)
    }

    @Test
    fun `Given news category all when getNews should return Success`() = runBlockingMainTest {
        //GIVEN
        val flowQuestions = flowOf(Resource.Success(getDummyNewsData()))

        //WHEN
        Mockito.doReturn(flowQuestions).`when`(newsUseCaseTemp).getNews("all")
        newsListViewModel.getNews("all")

        //THEN
        Assert.assertEquals(newsListViewModel.newsList.value.data?.size, 1)
    }
}