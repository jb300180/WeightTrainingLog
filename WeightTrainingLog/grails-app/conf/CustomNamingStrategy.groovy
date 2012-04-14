
// jb: q.v.:
// http://grails.org/doc/latest/guide/GORM.html#customNamingStrategy

import org.hibernate.cfg.ImprovedNamingStrategy
import org.hibernate.util.StringHelper

class CustomNamingStrategy extends ImprovedNamingStrategy {

	String classToTableName(String className) {
		"tbl_" + StringHelper.unqualify(className)
	}

	String propertyToColumnName(String propertyName) {
		"col_" + StringHelper.unqualify(propertyName)
	}
}
