import org.codehaus.groovy.grails.orm.hibernate.HibernateEventListeners;

beans = {
   dbChange(DBChangeListener)

   hibernateEventListeners(HibernateEventListeners) {
      listenerMap = ['post-insert': dbChange,
                     'post-update': dbChange,
                     'post-delete': dbChange]
   }
}