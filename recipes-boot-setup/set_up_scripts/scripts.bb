SUMMARY = "set_script"
SECTION = "set_script"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}"

SRC_URI = "\
	file://S39wifi_set_up.sh \
	file://S39bt_set_up.sh \
	file://fan.sh  \
	file://S39audio_set_up.sh \
	file://rk3588s-khadas-edge2.dtb.overlay.env \
	file://mipi-panel.dtbo \
	file://spi.dtbo \
	"

do_install() {
	install -m 0755 -d ${D}${sysconfdir}/rcS.d/
	install -m 0755 ${S}/S39wifi_set_up.sh ${D}${sysconfdir}/rcS.d/
	install -m 0755 ${S}/S39bt_set_up.sh ${D}${sysconfdir}/rcS.d/
	install -m 0755 ${S}/S39audio_set_up.sh ${D}${sysconfdir}/rcS.d/

	install -d ${D}${bindir}
	cp ${S}/fan.sh ${D}${bindir}

	install -d ${D}/boot/dtb/rockchip/rk3588s-khadas-edge2.dtb.overlays/
	install -m 0644 ${S}/rk3588s-khadas-edge2.dtb.overlay.env ${D}/boot/dtb/rockchip/
	install -m 0644 ${S}/mipi-panel.dtbo ${D}/boot/dtb/rockchip/rk3588s-khadas-edge2.dtb.overlays/
	install -m 0644 ${S}/spi.dtbo ${D}/boot/dtb/rockchip/rk3588s-khadas-edge2.dtb.overlays/
}

FILES:${PN} += "${sysconfdir}/rcS.d/S39wifi_set_up.sh"
FILES:${PN} += "${sysconfdir}/rcS.d/S39bt_set_up.sh"
FILES:${PN} += "${sysconfdir}/rcS.d/S39audio_set_up.sh"
FILES:${PN} += "${bindir}/fan.sh"
FILES:${PN} += "/boot/dtb/rockchip/rk3588s-khadas-edge2.dtb.overlay.env"
FILES:${PN} += "/boot/dtb/rockchip/rk3588s-khadas-edge2.dtb.overlays/mipi-panel.dtbo"
FILES:${PN} += "/boot/dtb/rockchip/rk3588s-khadas-edge2.dtb.overlays/spi.dtbo"
