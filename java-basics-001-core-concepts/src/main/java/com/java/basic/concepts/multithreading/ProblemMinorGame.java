package com.java.basic.concepts.multithreading;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ProblemMinorGame {
	
	static class MineLayer implements Runnable {

		private final int id;
		private final Board board;
		private volatile boolean layerRunning;
		
		public MineLayer(int id, Board board) {
			this.id = id;
			this.board = board;
			this.layerRunning = true;
		}
		
		@Override
		public void run() {
			
			Random random = new Random();
			
			while (layerRunning) {
				
				if (Thread.currentThread().isInterrupted()) {
					return;
				}
				
				int index = random.nextInt(Constants.BOARD_ROWS * Constants.BOARD_COLUMNS);
				board.setMine(index);
				
				try {
					Thread.sleep(200);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		public void setLayerRunning(boolean layerRunning) {
			this.layerRunning = layerRunning;
		}

		@Override
		public String toString() {
			return "" + this.id;
		}
	}

	static class MineSweeper implements Runnable {
		
		private final int id;
		private final Board board;
		private volatile boolean sweeperRunning;

		public MineSweeper(int id, Board board) {
			this.id = id;
			this.board = board;
			this.sweeperRunning = true;
		}

		@Override
		public void run() {

			Random random = new Random();

			while (sweeperRunning) {

				if (Thread.currentThread().isInterrupted()) {
					return;
				}

				int index = random.nextInt(Constants.BOARD_ROWS * Constants.BOARD_COLUMNS);
				board.sweepMine(index);

				try {
					Thread.sleep(200);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public void setSweeperRunning(boolean sweeperRunning) {
			this.sweeperRunning = sweeperRunning;
		}
		
		@Override
		public String toString() {
			return "" + this.id;
		}
	}

	static class Board extends JPanel {
		
		private static final long serialVersionUID = 1L;
		private Cell[] cells;
		private int numberOfMines;
		
		public Board() {
			initializeClass();
			setLayout(new GridLayout(Constants.BOARD_ROWS, Constants.BOARD_COLUMNS));
			initializeBoard();
		}
		
		public synchronized void incrementBombNumber() {
			this.numberOfMines++;
		}
		
		public synchronized void decrementBombNumber() {
			this.numberOfMines--;
		}
		
		private void initializeBoard() {
			for (int i = 0; i < Constants.BOARD_COLUMNS * Constants.BOARD_ROWS; i++) {
				
				cells[i] = new Cell(i + 1);
				add(cells[i]);
				
				int row = (i / Constants.BOARD_ROWS) % 2;
				
				if (row == 0) {
					cells[i].setBackground(i % 2 == 0 ? Color.GRAY : Color.WHITE);
				}
				else {
					cells[i].setBackground(i % 2 == 0 ? Color.WHITE : Color.GRAY);
				}
			}
		}
		
		private void initializeClass() {
			this.cells = new Cell[Constants.BOARD_ROWS * Constants.BOARD_COLUMNS];
			this.numberOfMines = 0;
		}
		
		public void setMine(int index) {
			cells[index].lock();
			incrementBombNumber();
			cells[index].setBackground(Color.RED);
			cells[index].unlock();

			sleepThread(500);
		}

		public void sweepMine(int index) {

			cells[index].lock();
			decrementBombNumber();

			int row = (index / Constants.BOARD_ROWS) % 2;

			if (row == 0) {
				cells[index].setBackground(index % 2 == 0 ? Color.GRAY : Color.WHITE);
			}
			else {
				cells[index].setBackground(index % 2 == 0 ? Color.WHITE : Color.GRAY);
			}

			cells[index].unlock();

			sleepThread(500);

		}

		public void clearBoard() {
			for (int i = 0; i < Constants.BOARD_COLUMNS * Constants.BOARD_ROWS; i++) {
				
				int row = (i / Constants.BOARD_ROWS) % 2;
				
				if (row == 0) {
					cells[i].setBackground(i % 2 == 0 ? Color.GRAY : Color.WHITE);
				}
				else {
					cells[i].setBackground(i % 2 == 0 ? Color.WHITE : Color.GRAY);
				}
			}
		}
		
		private void sleepThread(int duration) {
			try {
				Thread.sleep(duration);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public int getNumberOfMines() {
			return this.numberOfMines;
		}
	}

	static class Cell extends JPanel {
		
		private static final long serialVersionUID = 1L;
		private int id;
		private Lock lock;
		private State state;
		private boolean hasBomb;

		public Cell(int id) {
			initVariables(id);
			setLayout(new GridLayout());
		}
		
		private void initVariables(int id) {
			this.id = id;
			this.lock = new ReentrantLock();
			this.state = State.EMPTY;
			this.hasBomb = false;
		}

		public void lock() {
			try {
				lock.tryLock(10, TimeUnit.HOURS);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void unlock() {
			lock.unlock();
		}
		
		@Override
		public String toString() {
			return "" + this.id + "-" + state.toString() + "-" + hasBomb;
		}
	}

	public interface ButtonListener {
		public void startClicked();
		public void stopClicked();
	}

	static class Toolbar extends JPanel implements ActionListener {
		
		private static final long serialVersionUID = 1L;
		private JButton startButton;
		private JButton stopButton;
		private ButtonListener listener;

		public Toolbar() {

			setLayout(new FlowLayout(FlowLayout.CENTER));

			initVariables();

			add(startButton);
			add(stopButton);
		}
		
		private void initVariables() {
			this.startButton = new JButton("Start");
			this.stopButton = new JButton("Stop");
			this.startButton.addActionListener(this);
			this.stopButton.addActionListener(this);
		}
		
		public void setButtonListener(ButtonListener listener) {
			this.listener = listener;
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			if ((JButton) event.getSource() == startButton && this.listener != null) {
				this.listener.startClicked();
			}
			else {
				this.listener.stopClicked();
			}
		}
	}
	
	public class Constants {
		
		private Constants() {

		}

		public static final int NUMBER_OF_SWEEPERS = 1000;
		public static final int NUMBER_OF_LAYERS = 200;
		public static final int BOARD_ROWS = 10;
		public static final int BOARD_COLUMNS = 10;
		public static final int BOARD_WIDTH = 800;
		public static final int BOARD_HEIGHT = 650;
		public static final String APP_NAME = "Mine simulation!";

	}

	public enum State {
		EMPTY, MINE, MINESWEEPER, MINELAYER;
	}

	static class MainFrame extends JFrame implements ButtonListener {
		
		private static final long serialVersionUID = 1L;
		private final Toolbar toolbar;
		private final Board board;
		private ExecutorService layersExecutor;
		private ExecutorService sweepersExecutor;
		private MineLayer[] mineLayers;
		private MineSweeper[] mineSweepers;

		public MainFrame() {
			super(Constants.APP_NAME);

			toolbar = new Toolbar();
			board = new Board();

			initializeVariables();
			
			toolbar.setButtonListener(this);

			add(toolbar, BorderLayout.NORTH);
			add(board, BorderLayout.CENTER);

			setSize(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		private void initializeVariables() {
			mineLayers = new MineLayer[Constants.NUMBER_OF_LAYERS];
			mineSweepers = new MineSweeper[Constants.NUMBER_OF_SWEEPERS];
		}
		
		@Override
		public void startClicked() {

			this.layersExecutor = Executors.newFixedThreadPool(Constants.NUMBER_OF_LAYERS);
			this.sweepersExecutor = Executors.newFixedThreadPool(Constants.NUMBER_OF_SWEEPERS);
			
			try {

				for (int i = 0; i < Constants.NUMBER_OF_LAYERS; i++) {
					mineLayers[i] = new MineLayer(i, board);
					layersExecutor.execute(mineLayers[i]);
				}

				for (int i = 0; i < Constants.NUMBER_OF_SWEEPERS; i++) {
					mineSweepers[i] = new MineSweeper(i, board);
					sweepersExecutor.execute(mineSweepers[i]);
				}

			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				layersExecutor.shutdown();
				sweepersExecutor.shutdown();
			}
		}
		
		@Override
		public void stopClicked() {

			for (MineLayer mineLayer : this.mineLayers) {
				mineLayer.setLayerRunning(false);
			}

			for (MineSweeper mineSweeper : this.mineSweepers) {
				mineSweeper.setSweeperRunning(false);
			}

			layersExecutor.shutdown();
			sweepersExecutor.shutdown();

			try {
				layersExecutor.awaitTermination(1, TimeUnit.MINUTES);
				sweepersExecutor.awaitTermination(1, TimeUnit.MINUTES);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}

			layersExecutor.shutdownNow();
			sweepersExecutor.shutdownNow();

			this.board.clearBoard();

		}
	}

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (InstantiationException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainFrame();
			}
		});
	}
	
}
