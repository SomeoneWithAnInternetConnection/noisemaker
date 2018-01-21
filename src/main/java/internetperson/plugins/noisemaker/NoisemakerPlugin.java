package internetperson.plugins.noisemaker;

import com.google.inject.Binder;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PluginDescriptor(
	name = "Noisemaker"
)
public class NoisemakerPlugin extends Plugin
{
	private static final Logger logger = LoggerFactory.getLogger(NoisemakerPlugin.class);

	@Inject
	Client client;

	@Inject
	ClientUI ui;

	NoisemakerPanel panel;

	private NavigationButton navButton;

	@Override
	protected void startUp() throws Exception {
		panel = injector.getInstance(NoisemakerPanel.class);
		navButton = new NavigationButton("Noisemaker",
				ImageIO.read(getClass().getResourceAsStream("icon.png")),
				() -> panel);
		ui.getPluginToolbar().addNavigation(navButton);
	}

	@Override
	protected void shutDown() throws Exception {
		ui.getPluginToolbar().removeNavigation(navButton);
	}

	@Override
	public void configure(Binder binder)
	{
		binder.bind(NoisemakerPanel.class);
	}


}
