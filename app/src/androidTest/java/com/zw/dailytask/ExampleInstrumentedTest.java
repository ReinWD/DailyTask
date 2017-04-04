package com.zw.dailytask;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.zw.dailytask.utils.Json;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void fuckyou(){
        Json json = new Json("{\n" +
                "        \"error\": false,\n" +
                "        \"results\": [\n" +
                "        {\n" +
                "        \"_id\": \"58d08621421aa95810795ca1\",\n" +
                "        \"createdAt\": \"2017-03-21T09:47:13.3Z\",\n" +
                "        \"desc\": \"3-21\",\n" +
                "        \"publishedAt\": \"2017-03-21T12:19:46.895Z\",\n" +
                "        \"source\": \"chrome\",\n" +
                "        \"type\": \"\\u798f\\u5229\",\n" +
                "        \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-21-17268102_763630507137257_3620762734536163328_n%20-1-.jpg\",\n" +
                "        \"used\": true,\n" +
                "        \"who\": \"dmj\"\n" +
                "        },\n" +
                "        {\n" +
                "        \"_id\": \"58cf3696421aa90f13178695\",\n" +
                "        \"createdAt\": \"2017-03-20T09:55:34.360Z\",\n" +
                "        \"desc\": \"3-20\",\n" +
                "        \"publishedAt\": \"2017-03-20T11:44:56.224Z\",\n" +
                "        \"source\": \"chrome\",\n" +
                "        \"type\": \"\\u798f\\u5229\",\n" +
                "        \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-20-17333300_1680707251945881_2009298023053524992_n.jpg\",\n" +
                "        \"used\": true,\n" +
                "        \"who\": \"daimajia\"\n" +
                "        },\n" +
                "        {\n" +
                "        \"_id\": \"58cb5f88421aa95810795c80\",\n" +
                "        \"createdAt\": \"2017-03-17T12:01:12.88Z\",\n" +
                "        \"desc\": \"3-17\",\n" +
                "        \"publishedAt\": \"2017-03-17T12:07:03.767Z\",\n" +
                "        \"source\": \"chrome\",\n" +
                "        \"type\": \"\\u798f\\u5229\",\n" +
                "        \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-17-17332809_1277469728986540_3201752429582352384_n.jpg\",\n" +
                "        \"used\": true,\n" +
                "        \"who\": \"dmj\"\n" +
                "        },\n" +
                "        {\n" +
                "        \"_id\": \"58c9f47f421aa95810795c73\",\n" +
                "        \"createdAt\": \"2017-03-16T10:12:15.342Z\",\n" +
                "        \"desc\": \"3-16\",\n" +
                "        \"publishedAt\": \"2017-03-16T11:37:02.85Z\",\n" +
                "        \"source\": \"chrome\",\n" +
                "        \"type\": \"\\u798f\\u5229\",\n" +
                "        \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-16-17333221_108837802984751_2789267558635667456_n.jpg\",\n" +
                "        \"used\": true,\n" +
                "        \"who\": \"dmj\"\n" +
                "        },\n" +
                "        {\n" +
                "        \"_id\": \"58c8adee421aa90f1317866e\",\n" +
                "        \"createdAt\": \"2017-03-15T10:58:54.268Z\",\n" +
                "        \"desc\": \"3-15\",\n" +
                "        \"publishedAt\": \"2017-03-15T11:47:17.825Z\",\n" +
                "        \"source\": \"chrome\",\n" +
                "        \"type\": \"\\u798f\\u5229\",\n" +
                "        \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-15-17126482_115753765623699_4225645012014071808_n.jpg\",\n" +
                "        \"used\": true,\n" +
                "        \"who\": \"dmj\"\n" +
                "        },\n" +
                "        {\n" +
                "        \"_id\": \"58c72e86421aa90efc4fb6c5\",\n" +
                "        \"createdAt\": \"2017-03-14T07:43:02.751Z\",\n" +
                "        \"desc\": \"3-14\",\n" +
                "        \"publishedAt\": \"2017-03-14T13:17:14.21Z\",\n" +
                "        \"source\": \"chrome\",\n" +
                "        \"type\": \"\\u798f\\u5229\",\n" +
                "        \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-13-17267506_264626920661300_5781854075880472576_n.jpg\",\n" +
                "        \"used\": true,\n" +
                "        \"who\": \"\\u5e26\\u9a6c\\u7532\"\n" +
                "        },\n" +
                "        {\n" +
                "        \"_id\": \"58c5e184421aa90f1317864d\",\n" +
                "        \"createdAt\": \"2017-03-13T08:02:12.179Z\",\n" +
                "        \"desc\": \"3-13\",\n" +
                "        \"publishedAt\": \"2017-03-13T12:37:59.782Z\",\n" +
                "        \"source\": \"chrome\",\n" +
                "        \"type\": \"\\u798f\\u5229\",\n" +
                "        \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-13-17265708_396005157434387_3099040288153272320_n.jpg\",\n" +
                "        \"used\": true,\n" +
                "        \"who\": \"dmj\"\n" +
                "        },\n" +
                "        {\n" +
                "        \"_id\": \"58c1f808421aa95810795c34\",\n" +
                "        \"createdAt\": \"2017-03-10T08:49:12.756Z\",\n" +
                "        \"desc\": \"3-10\",\n" +
                "        \"publishedAt\": \"2017-03-10T11:43:50.30Z\",\n" +
                "        \"source\": \"chrome\",\n" +
                "        \"type\": \"\\u798f\\u5229\",\n" +
                "        \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-10-17127037_231706780569079_1119464847537340416_n.jpg\",\n" +
                "        \"used\": true,\n" +
                "        \"who\": \"\\u4ee3\\u7801\\u5bb6\"\n" +
                "        },\n" +
                "        {\n" +
                "        \"_id\": \"58c0ac1f421aa90f03345143\",\n" +
                "        \"createdAt\": \"2017-03-09T09:13:03.655Z\",\n" +
                "        \"desc\": \"3-9\",\n" +
                "        \"publishedAt\": \"2017-03-09T11:42:30.849Z\",\n" +
                "        \"source\": \"chrome\",\n" +
                "        \"type\": \"\\u798f\\u5229\",\n" +
                "        \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-09-17127109_1652837611687612_1425055271046086656_n.jpg\",\n" +
                "        \"used\": true,\n" +
                "        \"who\": \"daimajia\"\n" +
                "        },\n" +
                "        {\n" +
                "        \"_id\": \"58bf522a421aa90efc4fb689\",\n" +
                "        \"createdAt\": \"2017-03-08T08:36:58.695Z\",\n" +
                "        \"desc\": \"3-8\",\n" +
                "        \"publishedAt\": \"2017-03-08T11:27:16.65Z\",\n" +
                "        \"source\": \"chrome\",\n" +
                "        \"type\": \"\\u798f\\u5229\",\n" +
                "        \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-08-17126216_1253875034703554_7520300169779216384_n.jpg\",\n" +
                "        \"used\": true,\n" +
                "        \"who\": \"daimajia\"\n" +
                "        }\n" +
                "        ]\n" +
                "        }");
        HashMap<String ,Json.Value> target;
        target = json.analyzeData();
        int x = 1;
    }
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.zw.dailytask", appContext.getPackageName());

    }


}
