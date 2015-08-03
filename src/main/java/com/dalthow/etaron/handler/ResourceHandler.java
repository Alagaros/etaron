package com.dalthow.etaron.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.util.ResourceLoader;

import com.dalthow.etaron.media.ImageResource;
import com.dalthow.etaron.media.MusicResource;
import com.dalthow.etaron.media.SoundResource;

/**
 * Etaron
 *
 * 
 * @author Dalthow Game Studios 
 * @class ResourceHandler.java
 * 
 **/

public class ResourceHandler 
{
	// Declaration of the hash maps that hold all the resources.
	
	public Map<ImageResource.Levels, Image> levels = new HashMap<>(ImageResource.Levels.values().length);
	public Map<SoundResource, Sound> sounds = new HashMap<>(SoundResource.values().length);
	public Map<MusicResource, Music> musics = new HashMap<>(MusicResource.values().length);
	
	
	// Loads all declared sounds.
	
	public void loadSounds() throws SlickException
	{
		for(SoundResource sound : SoundResource.values())
		{
			sounds.put(sound, new Sound(ResourceLoader.getResourceAsStream(sound.getPath()), sound.getPath()));
		}
	}
	
	
	// Loads all declared levels.
	
	public void loadLevels() throws SlickException
	{
		for(ImageResource.Levels image : ImageResource.Levels.values())
		{
			if(image.name().startsWith("LEVEL_"))
			{
				levels.put(image, new Image(ResourceLoader.getResourceAsStream(image.getPath()), image.name(), false));
			}
		}
	}
	
	
	// Gets an image.
	
	public Image get(ImageResource image) throws SlickException, IOException
	{
		return new Image(ResourceLoader.getResourceAsStream(image.getPath()), image.name(), false);
	}

	
	// Gets an music file.
	
	@Deprecated
	public Music get(MusicResource music) throws SlickException
	{
		return new Music(ResourceLoader.getResourceAsStream(music.getPath()), music.getPath());
	}

	
	// Gets a sounds file.
	
	@Deprecated
	public Sound get(SoundResource sound) throws SlickException
	{
		return new Sound(ResourceLoader.getResourceAsStream(sound.getPath()), sound.getPath());
	}
}
