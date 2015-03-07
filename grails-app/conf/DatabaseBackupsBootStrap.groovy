import com.theconnman.databasebackups.BackupJob;

class DatabaseBackupsBootStrap {
	
	def grailsApplication

	def init = { servletContext ->
		int interval = grailsApplication.mergedConfig.grails.plugin.databasebackups.interval;
		BackupJob.schedule(interval);
	}
}
