package com.narendra.news_data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.narendra.common.model.Resource
import com.narendra.news_data.data.remote.NewsAPIService
import com.narendra.news_data.data.repository.NewsRepositoryImpl
import com.narendra.news_domain.repository.NewsRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class NewsRepositoryImplTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private lateinit var newsRepository: NewsRepository

    @Mock
    lateinit var newsAPIService: NewsAPIService


    @Before
    fun setUp() {
        newsRepository = NewsRepositoryImpl(newsAPIService)
    }

    @Test
    fun `Given Characters When fetchCharacters returns Success`() = runBlocking {
        //GIVEN
        val givenNews = getNews()
        val givenNewsOutput = Resource.Success(givenNews)
        val inputFlow = listOf(Resource.Loading(), Resource.Success(givenNewsOutput))
        `when`(newsAPIService.getNews("all")).thenReturn(givenNews)

        //WHEN
        val outputFlow = newsRepository.getNews("all").toList()

        //THEN
        Assert.assertEquals(outputFlow.size,  2)
        Assert.assertEquals(inputFlow[0].data, outputFlow[0].data)
        Assert.assertEquals(inputFlow[1].data?.data?.data, outputFlow[1].data)
    }
}