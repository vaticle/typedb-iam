package com.vaticle.typedb.iam.simulation.common.concept

import com.vaticle.typedb.client.api.concept.Concept
import com.vaticle.typedb.iam.simulation.common.Util.booleanValue
import com.vaticle.typedb.iam.simulation.common.Util.longValue

data class Permission(val permittedSubject: Subject, val permittedAccess: Access, val validity: Boolean, val reviewDate: Long) {
    constructor(permittedSubject: Subject, permittedAccess: Access, validity: Concept, reviewDate: Concept):
            this(permittedSubject, permittedAccess, booleanValue(validity), longValue(reviewDate))
}