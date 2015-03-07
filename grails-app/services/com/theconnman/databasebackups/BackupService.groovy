package com.theconnman.databasebackups

import grails.transaction.Transactional
import org.h2.tools.Script;

@Transactional
class BackupService {
	
	def grailsApplication
	
	boolean dirty = true;

    void backup() {
		File backup = makeBackup();
    }
	
	boolean getDirty() {
		return dirty;
	}
	
	void setDirty(boolean isDirty) {
		dirty = isDirty;
	}
	
	File makeBackup() {
		String dbUrl = grailsApplication.config.dataSource.url;
		String user = grailsApplication.config.dataSource.username;
		String password = grailsApplication.config.dataSource.password;
		Map config = grailsApplication.mergedConfig.grails.plugin.databasebackups;
		File backup = grailsApplication.mainContext.getResource(new Date().format(config.dateFormat) + config.prefix + '.sql').file;
		Script h2Script = new Script();
		h2Script.execute(dbUrl, user, password, backup.absolutePath);
		return backup;
	}
}
