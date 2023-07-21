package net.minecraft.src;

class ThreadRunIsoClient extends Thread {
	final CanvasIsomPreview isoCanvas;

	ThreadRunIsoClient(CanvasIsomPreview var1) {
		this.isoCanvas = var1;
	}

	public void run() {
		while(CanvasIsomPreview.isRunning(this.isoCanvas)) {
			this.isoCanvas.func_1265_d();

			try {
				Thread.sleep(1L);
			} catch (Exception var2) {
			}
		}

	}
}
