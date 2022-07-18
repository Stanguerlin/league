package br.com.cwi.nespresso_app.domain.entity

class Machine(
    id: Int,
    name: String,
    urlImage: String?,
    unitPrice: Double,
    var description: String,
    var imageUrl: String,
) : Product(
    id,
    name,
    urlImage,
    unitPrice
  )