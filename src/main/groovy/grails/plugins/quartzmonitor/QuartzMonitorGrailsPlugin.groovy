package grails.plugins.quartzmonitor

import grails.plugins.GrailsVersionUtils
import grails.plugins.Plugin
import grails.plugins.quartz.QuartzMonitorJobFactory

class QuartzMonitorGrailsPlugin extends Plugin {
    def grailsVersion = "6.2.0 > *"

    def author = "James Cook"
    def authorEmail = "grails@jamescookie.com"
    def title = "Quartz Monitor Grails Plugin"
    def description = 'One clear and concise page that enables you to administer all your Quartz jobs'

    def documentation = "http://grails.org/plugin/quartz-monitor"

    def license = "APACHE"
    def scm = [url: "http://github.com/jamescookie/quartz-monitor"]
    def issueManagement = [system: "GITHUB", url: "http://github.com/jamescookie/quartz-monitor/issues"]

    def loadAfter = ['quartz']

    @Override
    Closure doWithSpring() {
        { ->
            quartzJobFactory(QuartzMonitorJobFactory) {
                if (manager?.hasGrailsPlugin("hibernate") || manager?.hasGrailsPlugin("hibernate4") || manager?.hasGrailsPlugin("hibernate5")) {
                    //https://github.com/hibernate/hibernate-orm/blob/5.2/migration-guide.adoc#misc due to which allow_update_outside_transaction check added.
                    if (!GrailsVersionUtils.isVersionGreaterThan("7.0.0", pluginManager.getGrailsPlugin('hibernate').version) || grailsApplication.config.getProperty('hibernate.allow_update_outside_transaction', Boolean, false))
                        sessionFactory = ref("sessionFactory")
                }
                pluginManager = ref("pluginManager")
            }
        }
    }
}
