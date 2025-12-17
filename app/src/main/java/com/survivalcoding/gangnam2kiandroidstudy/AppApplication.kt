package com.survivalcoding.gangnam2kiandroidstudy

import android.app.Application
import com.survivalcoding.gangnam2kiandroidstudy.core.di.appModule
import com.survivalcoding.gangnam2kiandroidstudy.core.di.datasourceModule
import com.survivalcoding.gangnam2kiandroidstudy.core.di.repositoryModule
import com.survivalcoding.gangnam2kiandroidstudy.core.di.useCaseModule
import com.survivalcoding.gangnam2kiandroidstudy.core.di.viewModelModule
import com.survivalcoding.gangnam2kiandroidstudy.data.datasource.MockRecipeDataSourceImpl
import com.survivalcoding.gangnam2kiandroidstudy.data.datasource.MockUserDataSourceImpl
import com.survivalcoding.gangnam2kiandroidstudy.data.datasource.ProcedureDataSoureImpl
import com.survivalcoding.gangnam2kiandroidstudy.data.repository.BookmarkRepositoryImpl
import com.survivalcoding.gangnam2kiandroidstudy.data.repository.IngridentRepositoryImpl
import com.survivalcoding.gangnam2kiandroidstudy.data.repository.ProcedureRepositoryImpl
import com.survivalcoding.gangnam2kiandroidstudy.domain.repository.RecipeRepository
import com.survivalcoding.gangnam2kiandroidstudy.data.repository.RecipeRepositoryImpl
import com.survivalcoding.gangnam2kiandroidstudy.domain.repository.BookmarkRepository
import com.survivalcoding.gangnam2kiandroidstudy.domain.repository.IngridentRepository
import com.survivalcoding.gangnam2kiandroidstudy.domain.repository.ProcedureRepository
import com.survivalcoding.gangnam2kiandroidstudy.domain.usecase.GetRecipeDetailsUseCase
import com.survivalcoding.gangnam2kiandroidstudy.domain.usecase.GetSavedRecipesUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppApplication : Application() {

    val recipeRepository: RecipeRepository by lazy {
        RecipeRepositoryImpl(
            recipeDataSource = MockRecipeDataSourceImpl()
        )
    }
    val bookmarkRepository: BookmarkRepository by lazy {
        BookmarkRepositoryImpl(
            userDataSource = MockUserDataSourceImpl()
        )
    }
    val procedureRepository: ProcedureRepository by lazy {
        ProcedureRepositoryImpl(
            procedureDataSource = ProcedureDataSoureImpl()
        )
    }

    val ingridentRepository: IngridentRepository by lazy {
        IngridentRepositoryImpl(
            recipeDataSource = MockRecipeDataSourceImpl()
        )
    }
    val getSavedRecipesUseCase: GetSavedRecipesUseCase by lazy {
        GetSavedRecipesUseCase(
            recipeRepository = recipeRepository,
            bookmarkRepository = bookmarkRepository
        )
    }

    val getRecipeDetailsUseCase: GetRecipeDetailsUseCase by lazy {
        GetRecipeDetailsUseCase(
            recipeRepository = recipeRepository,
            procedureRepository = procedureRepository,
            ingridentRepository = ingridentRepository
        )
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger() // koin 주입할 때 Log 나오게 하는 옵션 (없어도 된다.)
            androidContext(this@AppApplication) //data layer에 context가 필요할 때 굉장히 쉽게 전달 가능하게 해줌.
            modules(
                appModule,
                datasourceModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }

}