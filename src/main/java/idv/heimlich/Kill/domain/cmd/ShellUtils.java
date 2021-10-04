package idv.heimlich.Kill.domain.cmd;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ShellUtils {

//	final static CommonLogger LOG = MyLoggerFactory.getLogger(Mylogs.clJobCmd);

	public static void cmd(final String file, final String cmd) {
		final File outLogFile = new File(file);

		try {
//			LOG.info("Execute Commend ->" + cmd);

			final Runtime runtime = Runtime.getRuntime();
			final Process process = runtime.exec(cmd);
			final BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			final BufferedReader stderrReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			outLogFile.delete();
			outLogFile.createNewFile();

			String line;
			final List<String> stds = new ArrayList<String>();
			stds.add("###############LOG:###################\n");
			while ((line = stdoutReader.readLine()) != null) {
				stds.add(line);
//				LOG.info("line:" + line);
			}

			stds.add("###############ERROR LOG:#############\n");
			while ((line = stderrReader.readLine()) != null) {
				stds.add(line);
//				LOG.info("error line:" + line);
			}
			FileUtils.writeLines(outLogFile, "UTF-8", stds);

			final int exitValue = process.waitFor();
//			LOG.info("Exit Value :" + exitValue);
		} catch (final Exception e) {
//			LOG.error("error{}", e);
		}
	}

}
