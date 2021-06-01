package com.poit.watchapp_kotlin.models

import java.io.Serializable

class Item(
    _id: String?,
    _name: String?,
    _style: String?,
    _caseColor: String?,
    _caseMaterial: String?,
    _description: String?,
    _avatarUrl: String?,
    _latitude: Double?,
    _longitude: Double?
) : Serializable {
    public var id: String? = _id
    public var name: String? = _name
    public var style: String? = _style
    public var  caseColor: String?= _caseColor
    public var caseMaterial: String?= _caseMaterial
    public var description: String?= _description
    public var avatarUrl: String?= _avatarUrl
    public var latitude: Double? = _latitude
    public var longitude: Double? = _longitude

    constructor() : this("", "", "", "",
        "", "", "", 0.0, 0.0)
}