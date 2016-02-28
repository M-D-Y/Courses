package demo.image.filter;

import java.applet.Applet;
import java.awt.Image;

interface PluginFilter {
	Image filter(Applet а, Image in);
}