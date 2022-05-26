package com.atul.apps10xsampleproject.utils

interface EntityMapper<Entity,DomainModel> {

    fun mapFromEntity(entity: Entity) : DomainModel?

    fun mapToDomainModel(domainModel: DomainModel) : Entity?



}