import com.theconnman.databasebackups.BackupJob;

class DatabaseBackupsBootStrap {
	
	def grailsApplication

	def init = { servletContext ->
		Map config = grailsApplication.mergedConfig.grails.plugin.databasebackups;
		if (config.on) {
			BackupJob.schedule(config.interval);
		}
	}
}
