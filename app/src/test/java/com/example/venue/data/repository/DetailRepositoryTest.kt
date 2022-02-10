package com.example.venue.data.repository

import com.example.venue.data.model.Result
import com.example.venue.data.network.ApiService
import com.example.venue.data.network.DataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DetailRepositoryTest {
    lateinit var testObject: DetailRepository

    @Mock
    lateinit var dataSource: DataSource

    @Mock
    lateinit var apiService: ApiService


    @Before
    fun setUp() {
        testObject = DetailRepository(dataSource, apiService)
    }

    @Test
    fun fetchDetails() {
        runBlocking {
            Mockito.`when`(dataSource.executeCall { apiService.fetchDetails("123456") })
                .thenReturn(Result.Success("1"))
            val result = testObject.fetchDetails("123456")
            Assert.assertTrue(result is Result.Success<*>)
        }
    }
}