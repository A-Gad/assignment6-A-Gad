LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f098732a73b5f6f3430472f5b094ffdb"

SRC_URI = "git://github.com/A-Gad/assignment7-A-Gad;protocol=https;branch=main"
SRC_URI += "file://S98scull"

PV = "1.0+git${SRCPV}"
SRCREV = "3d5a9f955f99872a15b296353a3c356b5f0963bb"

S = "${WORKDIR}/git"

inherit module update-rc.d

INITSCRIPT_NAME = "S98scull"
INITSCRIPT_PARAMS = "defaults 98"

EXTRA_OEMAKE += " -C ${STAGING_KERNEL_DIR} M=${S}/scull"
FILES:${PN} += "${sysconfdir}/init.d/S98scull"

do_install:append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/S98scull ${D}${sysconfdir}/init.d/S98scull
}