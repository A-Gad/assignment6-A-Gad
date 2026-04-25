LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8ed1a118f474eea5e159b560c339329b"

SRC_URI = "git://github.com/A-Gad/assignment3-and-later-A-Gad.git;protocol=ssh;branch=master"
SRC_URI += "file://S97aesdchar"

PV = "1.0+git${SRCPV}"
SRCREV = "e7c8438749eea1702c28194335c57c5a7da59aad"

S = "${WORKDIR}/git"

inherit module update-rc.d

INITSCRIPT_NAME = "S97aesdchar"
INITSCRIPT_PARAMS = "defaults 97"

EXTRA_OEMAKE += " -C ${STAGING_KERNEL_DIR} M=${S}/aesd-char-driver"
FILES:${PN} += "${sysconfdir}/init.d/S97aesdchar"

do_install:append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/S97aesdchar ${D}${sysconfdir}/init.d/S97aesdchar
}