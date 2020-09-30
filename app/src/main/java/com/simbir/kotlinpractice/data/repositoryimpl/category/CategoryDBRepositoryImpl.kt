package com.simbir.kotlinpractice.data.repositoryimpl.category

import com.simbir.kotlinpractice.data.db.dao.CategoryDao
import com.simbir.kotlinpractice.data.db.map.DBCategoryMap
import com.simbir.kotlinpractice.domain.Category
import com.simbir.kotlinpractice.domain.repository.category.CategoryDBRepository
import io.reactivex.rxjava3.core.Single

class CategoryDBRepositoryImpl(
    private val categoryDao: CategoryDao,
    private val mapper: DBCategoryMap
): CategoryDBRepository {

    override fun getCategoryListFromDatabase(): Single<List<Category>> {
        return categoryDao.getAll()
            .flattenAsFlowable { categoryList -> categoryList }
            .map { category -> mapper.invoke(category) }
            .toList()
    }
}