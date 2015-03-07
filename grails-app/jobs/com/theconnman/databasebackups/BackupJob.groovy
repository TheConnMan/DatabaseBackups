package com.theconnman.databasebackups

import grails.util.Holders;

class BackupJob {
	
	def backupService
	
	static triggers = {
		simple repeatInterval: 5000 // execute job once in 5 seconds
	}

	def execute() {
		def config = Holders.getGrailsApplication().mergedConfig;
		println new Date()
		if (backupService.getDirty()) {
			println 'Dirty'
			backupService.setDirty(false);
		}
	}
}
