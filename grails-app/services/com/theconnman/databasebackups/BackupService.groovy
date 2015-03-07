package com.theconnman.databasebackups

import grails.transaction.Transactional
import org.h2.tools.Script;
import com.amazonaws.services.s3.AmazonS3Client;

@Transactional
class BackupService {
	
	def grailsApplication
	
	boolean dirty = true;

    void backup() {
		Map backupMap = makeBackup();
		S3backup(backupMap);
		backupMap.file.delete();
    }
	
	boolean getDirty() {
		return dirty;
	}
	
	void setDirty(boolean isDirty) {
		dirty = isDirty;
	}
	
	Map makeBackup() {
		String dbUrl = grailsApplication.config.dataSource.url;
		String user = grailsApplication.config.dataSource.username;
		String password = grailsApplication.config.dataSource.password;
		Map config = grailsApplication.mergedConfig.grails.plugin.databasebackups;
		Date date = new Date();
		File backup = grailsApplication.mainContext.getResource(date.format(config.folderFormat) + date.format(config.prefixFormat) + config.filename + '.sql').file;
		Script h2Script = new Script();
		h2Script.execute(dbUrl, user, password, backup.absolutePath);
		return [file: backup, date: date];
	}
	
	void S3backup(Map backupMap) {
		Map config = grailsApplication.mergedConfig.grails.plugin.databasebackups;
		AmazonS3Client s3 = new AmazonS3Client();
		s3.putObject(config.bucket, backupMap.date.format(config.folderFormat) + backupMap.file.name, backupMap.file);
	}
}
