# Quartz Monitor Plugin for Grails

Allows you to view and administer all your Quartz jobs in one place.

## Prerequisites

This plugin requires the [Quartz](http://grails.org/plugin/quartz) and [Asset Pipeline](http://grails.org/plugin/asset-pipeline) plugins to run.

## Installation
Add dependency to your build.gradle for Grails 6.x:

```
repositories {
  ...
  maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.Rxlogix:quartz-monitor:6.0-jdk11-M3'
}
```

In addition if you don't want to use jitpack.io then use following github package registry:

```groovy
repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/RxLogix/quartz-monitor")
            credentials {
                username = project.findProperty("gpr.user") ?: System.getenv("GITHUB_USERNAME")
                password = project.findProperty("gpr.key") ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
    
```


## Usage

Once you have the Quartz plugin installed and have created some jobs, then you will probably start wondering if they are all running as desired.

This is where you need the 'Quartz Monitor' plugin.

Simply install the plugin and go to the URL: http://localhost:8080/<yourapp>/quartz and you will find all a list of all the jobs you have scheduled to run.

## Enhanced Experience

To have the page keep you constantly up to date requires [jQuery](http://grails.org/plugin/jquery). It will still work without jQuery, but it won't look as good.

## Configuration

There are various configuration options, all start with `quartz.monitor`:

### layout

Allows you to change the sitemesh layout that page will use. Defaults to 'main'.

### showTriggerNames

If this is set to true, then the names of the triggers will be shown in the list - useful if you have multiple triggers for the same job.

### showCountdown

Will add javascript to the page in order to show a countdown to when the job will fire next, unless this is set to 'false'.

### showTickingClock

Will add javascript to the page in order to show a clock with the current time, unless this is set to 'false'.

