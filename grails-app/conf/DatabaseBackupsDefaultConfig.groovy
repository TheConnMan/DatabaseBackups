grails {
	plugin {
		databasebackups {
			interval = 60000
			prefixFormat = 'MM-SS'
			folderFormat = 'yyyy/MM/dd/HH/'
			filename = '-backup'
		}
	}
}