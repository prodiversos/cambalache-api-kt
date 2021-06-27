package com.cambalache.api

open class ApplicationResponse<out T> where T : Any {
    class Ok<out R>(val result: R) : ApplicationResponse<R>() where R : Any
    class Error<E>(val result: E) : ApplicationResponse<E>() where E : ApplicationResponseError
}