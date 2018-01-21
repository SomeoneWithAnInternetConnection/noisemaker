package internetperson.plugins.noisemaker;

import net.runelite.api.Client;
import net.runelite.api.SoundEffectID;
import net.runelite.client.ui.PluginPanel;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class NoisemakerPanel extends PluginPanel
{
	@Inject
	Client client;

	public NoisemakerPanel()
	{
		super();
		JSpinner spinner = new JSpinner(new SpinnerNumberModel());
		spinner.setValue(SoundEffectID.UI_BOOP);
		add(spinner);
		JButton playbutton = new JButton("Make a noise!");
		playbutton.addActionListener(e -> client.playSoundEffect((int)spinner.getValue()));
		add(playbutton);

	}
}
