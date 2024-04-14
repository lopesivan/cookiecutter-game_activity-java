MY_GRADLE_LOCAL = {{ cookiecutter.gradle_local }}

MANIFEST = app/src/main/AndroidManifest.xml
GRADLE   = ./gradlew

MAIN     = xmlstarlet select -T -t -v "//application/activity/@android:name" -n $(MANIFEST)
PACKAGE  = {{ cookiecutter.package_name }}

build: gradlew
	$(GRADLE) assemble

gradlew: init
init:
	$(MY_GRADLE_LOCAL) wrapper
back:
	# adb shell input keyevent 4
	adb shell input keyevent KEYCODE_BACK
home:
	# adb shell input keyevent 3
	adb shell input keyevent KEYCODE_HOME
run:
	adb shell am start -n $(PACKAGE)/`$(MAIN)`
install:
	$(GRADLE) $@Debug
uninstall:
	adb $@ $(PACKAGE)
clean:
	$(GRADLE) $@
