package com.example.brevisimo_news.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {

    override suspend fun signInAnonymously(): Flow<Resource<FirebaseUser>> = flow {
        emit(Resource.Loading)
        try {
            val authResult = firebaseAuth.signInAnonymously().await()

            val user = authResult.user

            if (user != null) {
                emit(Resource.Success(user))
            } else {
                emit(Resource.Error("El usuario de Firebase es nulo después de la autenticación anónima."))
            }
        } catch (e: Exception) {
            emit(Resource.Error("Fallo en la autenticación anónima: ${e.localizedMessage}", e))
        }
    }

    override fun isUserAnonymous(): Boolean {
        return firebaseAuth.currentUser?.isAnonymous ?: true
    }

    override fun getCurrentUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }

    override suspend fun signInWithGoogle(idToken: String): Flow<Resource<FirebaseUser>> = flow {
        emit(Resource.Loading)
        try {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            val authResult = firebaseAuth.signInWithCredential(credential).await()
            authResult.user?.let {
                emit(Resource.Success(it))
            } ?: emit(Resource.Error("Error al obtener usuario"))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Error desconocido"))
        }
    }

    override suspend fun signOut(): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading)
        try {
            firebaseAuth.signOut()
            emit(Resource.Success(Unit))
        } catch (e: Exception) {
            emit(Resource.Error("Error al cerrar sesión: ${e.localizedMessage}"))
        }
    }
}