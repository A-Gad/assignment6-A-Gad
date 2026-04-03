LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SRC_URI = "git://github.com/A-Gad/assignment3-and-later-A-Gad.git;protocol=ssh;branch=master"

PV = "1.0+git${SRCPV}"
SRCREV = "9f814552ce0cafff12d9a57b8637fb22a210dd24"

inherit update-rc.d
INITSCRIPT_PARAMS = "start 99 5 2 . stop 20 0 1 6 ."
INITSCRIPT_NAME = "aesdsocket-start-stop"

S = "${WORKDIR}/git/server"

FILES:${PN} += "${bindir}/aesdsocket ${sysconfdir}/init.d/aesdsocket-start-stop"
TARGET_LDFLAGS += "-pthread -lrt"

do_configure () {
	:
}

do_compile () {
	oe_runmake
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 aesdsocket ${D}${bindir}/aesdsocket
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${S}/aesdsocket-start-stop ${D}${sysconfdir}/init.d/aesdsocket-start-stop
}
