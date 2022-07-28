package com.prmto.borutoapp.data.paging_source

import androidx.paging.PagingSource
import com.prmto.borutoapp.data.remote.BorutoApi
import com.prmto.borutoapp.data.remote.FakeBorutoApi
import com.prmto.borutoapp.domain.model.Hero
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
class SearchHeroesSourceTest {

    private lateinit var borutoApi: BorutoApi
    private lateinit var heros: List<Hero>

    @Before
    fun setup() {
        borutoApi = FakeBorutoApi()
        heros = listOf(
            Hero(
                id = 1,
                name = "Sasuke",
                image = "",
                about = "",
                rating = 5.0,
                power = 0,
                month = "",
                day = "",
                family = listOf(),
                abilities = listOf(),
                natureTypes = listOf()
            ),
            Hero(
                id = 2,
                name = "Naruto",
                image = "",
                about = "",
                rating = 5.0,
                power = 0,
                month = "",
                day = "",
                family = listOf(),
                abilities = listOf(),
                natureTypes = listOf()
            ),
            Hero(
                id = 3,
                name = "Sakura",
                image = "",
                about = "",
                rating = 5.0,
                power = 0,
                month = "",
                day = "",
                family = listOf(),
                abilities = listOf(),
                natureTypes = listOf()
            )
        )
    }


    @Test
    fun `Search api with existing hero name, except single hero result, assert LoadResult_Page`() =
        runTest {
            val herosSource = SearchHeroesSource(
                borutoApi = borutoApi,
                query = "Sasuke"
            )
            assertEquals<PagingSource.LoadResult<Int, Hero>>(
                expected = PagingSource.LoadResult.Page(
                    data = listOf(heros.first()),
                    prevKey = null,
                    nextKey = null
                ),
                actual = herosSource.load(
                    PagingSource.LoadParams.Refresh(
                        key = null,
                        loadSize = 3,
                        placeholdersEnabled = false
                    )
                )
            )
        }

    @Test
    fun `Search api with existing hero name, except multiple hero result, assert LoadResult_Page`() =
        runTest {
            val herosSource = SearchHeroesSource(
                borutoApi = borutoApi,
                query = "Sa"
            )
            assertEquals<PagingSource.LoadResult<Int, Hero>>(
                expected = PagingSource.LoadResult.Page(
                    data = listOf(heros.first(), heros[2]),
                    prevKey = null,
                    nextKey = null
                ),
                actual = herosSource.load(
                    PagingSource.LoadParams.Refresh(
                        key = null,
                        loadSize = 3,
                        placeholdersEnabled = false
                    )
                )
            )
        }

    @Test
    fun `Search api with empty hero name, assert empty heroes list and LoadResult_Page`() =
        runTest {
            val herosSource = SearchHeroesSource(
                borutoApi = borutoApi,
                query = ""
            )

            val loadResult = herosSource.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 3,
                    placeholdersEnabled = false
                )
            )

            val result = borutoApi.searchHeroes("").heroes

            assertTrue { result.isEmpty() }
            assertTrue { loadResult is PagingSource.LoadResult.Page }

        }

    @Test
    fun `Search api with non_existing hero name, assert empty heroes list and LoadResult_Page`() =
        runTest {
            val herosSource = SearchHeroesSource(
                borutoApi = borutoApi,
                query = "Unknown"
            )

            val loadResult = herosSource.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 3,
                    placeholdersEnabled = false
                )
            )

            val result = borutoApi.searchHeroes("Unknown").heroes

            assertTrue { result.isEmpty() }
            assertTrue { loadResult is PagingSource.LoadResult.Page }

        }
}