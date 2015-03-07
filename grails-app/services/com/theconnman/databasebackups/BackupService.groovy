package com.theconnman.databasebackups

import grails.transaction.Transactional

@Transactional
class BackupService {
	
	boolean dirty = true;

    void backup() {
		println 'Backing up'
    }
	
	boolean getDirty() {
		return dirty;
	}
	
	void setDirty(boolean isDirty) {
		dirty = isDirty;
	}
}
