SUMMARY = "set_script"
SECTION = "set_script"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}"

SRC_URI = "\
	file://S39audio_set_up.sh \
	file://boot \
	file://etc/iqfiles/imx585_CMK-IMX585-PX1_FH34SRJ-30SCK0.json \
	file://etc/iqfiles/imx678_FH34SRJ-30S_YG4118.json \
	file://etc/iqfiles/os08a10_default_default.json \
	"

do_install() {
	install -m 0755 -d ${D}${sysconfdir}/rcS.d/
	install -m 0755 ${S}/S39audio_set_up.sh ${D}${sysconfdir}/rcS.d/

	install -m 0755 -d ${D}/
	cp -r ${S}/boot ${D}/

	install -m 0755 -d ${D}/etc/iqfiles/
	install -m 0755 ${S}/etc/iqfiles/imx585_CMK-IMX585-PX1_FH34SRJ-30SCK0.json ${D}/etc/iqfiles/
	install -m 0755 ${S}/etc/iqfiles/imx678_FH34SRJ-30S_YG4118.json ${D}/etc/iqfiles/
	install -m 0755 ${S}/etc/iqfiles/os08a10_default_default.json ${D}/etc/iqfiles/
}

FILES:${PN} += "${sysconfdir}/rcS.d/S39audio_set_up.sh"
FILES:${PN} += "/boot"
FILES:${PN} += "/etc/iqfiles/imx585_CMK-IMX585-PX1_FH34SRJ-30SCK0.json"
FILES:${PN} += "/etc/iqfiles/imx678_FH34SRJ-30S_YG4118.json"
FILES:${PN} += "/etc/iqfiles/os08a10_default_default.json"
