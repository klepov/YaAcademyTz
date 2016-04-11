package klep.yaacademytz;

import android.content.Intent;
import android.os.Bundle;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.internal.Shadow;
import org.robolectric.internal.bytecode.ShadowConfig;
import org.robolectric.util.FragmentTestUtil;
import klep.yaacademytz.allArtists.AllArtistFragment;
import klep.yaacademytz.detailArtist.DetailsArtistActivity;
import klep.yaacademytz.model.Artist;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.robolectric.shadows.support.v4.SupportFragmentTestUtil.startFragment;
import static org.robolectric.shadows.support.v4.SupportFragmentTestUtil.startVisibleFragment;

/**
 * Created by klep on 12.04.16 with love.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml")

public class AllArtistActivityTest {
    AllArtistActivity allArtistActivity;

    @Before
    public void setUp() throws Exception {
        allArtistActivity = Robolectric.buildActivity(AllArtistActivity.class)
                .create().get();

    }


    @Test
    public void testItemSend() throws Exception {
        allArtistActivity.itemSend(new Artist());

        Intent intent = Shadows.shadowOf(allArtistActivity).peekNextStartedActivity();
        assertEquals(DetailsArtistActivity.class.getCanonicalName(), intent.getComponent().getClassName());
    }

}