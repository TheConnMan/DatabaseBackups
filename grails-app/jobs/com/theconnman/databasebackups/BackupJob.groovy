package com.theconnman.databasebackups

import grails.util.Holders;

class BackupJob {
	
	def backupService

	def execute() {
		if (backupService.getDirty()) {
			backupService.backup();
			backupService.setDirty(false);
		}
	}
}
