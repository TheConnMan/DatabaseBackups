import org.codehaus.groovy.grails.commons.GrailsApplication
import org.hibernate.event.PostDeleteEvent;
import org.hibernate.event.PostDeleteEventListener;
import org.hibernate.event.PostInsertEvent;
import org.hibernate.event.PostInsertEventListener;
import org.hibernate.event.PostUpdateEvent;
import org.hibernate.event.PostUpdateEventListener;
import grails.util.Holders;

class DBChangeListener implements PostInsertEventListener, PostUpdateEventListener, PostDeleteEventListener {
	
	public void onPostInsert(final PostInsertEvent event) {
		setDirty();
	}
	
	public void onPostUpdate(final PostUpdateEvent event) {
		setDirty();
	}
	
	public void onPostDelete(final PostDeleteEvent event) {
		setDirty();
	}
	
	private void setDirty() {
		def grailsApplication = Holders.getGrailsApplication();
		def backupService = grailsApplication.getMainContext().getBean('backupService');
		backupService.setDirty(true);
	}
}