package com.example.networking.retrofit.utils

import com.example.networking.entities.Post
import retrofit2.Response
import retrofit2.http.*

interface PostsApi {

    // https://jsonplaceholder.typicode.com/posts
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>

    // https://jsonplaceholder.typicode.com/posts?userId=5
    @GET("posts")
    suspend fun getPostsByUser(
        @Query("userId") userId: Int
    ): Response<List<Post>>

    // https://jsonplaceholder.typicode.com/posts/1
    @GET("posts/{postId}")
    suspend fun getPostById(
        @Path("postId") postId: Int
    ): Response<Post>

    @POST("posts")
    suspend fun createNewPost(
        @Body post: Post
    ) : Response<Post>

    @DELETE("/posts/{postId}")
    suspend fun deletePost(
        @Path("postId") postId: Int
    )

    @PATCH("/posts/{postId}")
    suspend fun updatePost(
        @Path("postId") postId: Int,
        @Query("title") title: String,
        @Query("body") body: String
    )
}