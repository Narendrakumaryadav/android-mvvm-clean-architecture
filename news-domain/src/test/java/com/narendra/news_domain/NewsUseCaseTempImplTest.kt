package com.narendra.news_domain

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.narendra.comman.model.Resource
import com.narendra.news_domain.model.dto.NewsDataDto
import com.narendra.news_domain.repository.NewsRepository
import com.narendra.news_domain.use_case.NewsUseCaseImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class NewsUseCaseTempImplTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var newsRepository: NewsRepository
    private lateinit var newsUseCaseTemp: NewsUseCaseImpl

    @Before
    fun setUp() {
        newsUseCaseTemp = NewsUseCaseImpl(newsRepository)
    }

    @Test
    fun `Given Characters When UseCase fetchCharacters returns Success`() = runBlocking {
        //GIVEN
        val inputFlow: Flow<Resource<List<NewsDataDto>?>> = flow { emit(Resource.Success(data = getDummyNewsData())) }
        Mockito.`when`(newsRepository.getNews("all")).thenReturn(inputFlow)
        //WHEN
        val output = newsUseCaseTemp.getNews("all").toList()
        //THEN
        assert(output[0].data?.size == 1)
    }
}