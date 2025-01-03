# Stock Market Prediction Mobile App

The **Stock Market Prediction App** is a mobile application developed in **Java** for Android. It provides a platform for users to track stock prices, analyze market trends, and predict future stock movements using a machine learning model powered by a **Python API**. The app features a user authentication system using **SQLite** for secure login, and it utilizes **Retrofit** to interact with the backend Python API for stock predictions.

### Features

- **User Authentication**: Secure login functionality using SQLite to store user credentials locally. Users can register, log in, and manage their accounts securely.
- **Stock Price Prediction**: Provides real-time stock price predictions based on machine learning models. It leverages a Python-based backend API to generate predictions.
- **Historical Stock Data**: Displays historical stock prices with visualizations to help users track market trends.
- **Interactive Charts**: Visualizes stock price predictions and historical data through interactive graphs and charts.
- **Real-time API Integration**: Uses **Retrofit** to fetch stock price data and predictions from a Python backend.
- **Mobile Optimized**: The app is fully optimized for mobile use, providing smooth performance and a user-friendly experience.

### Technologies Used

- **Frontend (Android)**:
  - **Java**: The core programming language for the Android app.
  - **SQLite**: For storing user login credentials securely in the app’s local database.
  - **Retrofit**: To handle network requests and communicate with the Python backend API for stock price predictions.
  - **GraphView**: For displaying interactive stock price prediction charts.
  - **Android Studio**: The IDE used for app development.

- **Backend (Python)**:
  - **Flask**: Lightweight web framework used for creating the API that handles stock predictions.
  - **TensorFlow**: For building and training the machine learning models used for stock price predictions.
  - **SQLite/PostgreSQL**: Database for storing user data and stock information.

- **Authentication**:
  - **SQLite**: Securely stores user login information and credentials.

### How It Works

1. **User Authentication**:
   Users can sign up and log in securely using their credentials, which are stored locally in **SQLite**. The app checks the entered credentials and provides access if they match the stored records.

2. **Fetching Stock Data**:
   - The app allows users to input a stock ticker (e.g., AAPL, GOOG, TSLA) to get stock price data and predictions.
   - The app uses **Retrofit** to send requests to the Python-based backend, which retrieves historical stock data from sources like **Yahoo Finance** and makes predictions using an LSTM model trained on past stock data.

3. **Stock Price Prediction**:
   - The app fetches predicted stock prices from the backend and displays them alongside historical data.
   - The predictions are visualized in a line chart, allowing users to compare actual and predicted stock performance.

4. **Backend Communication**:
   - Retrofit is used to send requests to the **Flask** backend, which handles the stock prediction logic using **TensorFlow**.
   - The backend model processes the stock data and returns predicted future prices, which are displayed in the app.

5. **Interactive Visualization**:
   - Users can see historical stock prices, predicted future prices, and moving averages in interactive charts.
   - The chart updates in real-time as new predictions are received from the backend.

### Installation and Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/rohanmr551/stockify.git
   ```

2. **Install Dependencies**:
   - For the **Android app**:
     - Open the project in **Android Studio**.
     - Sync the project with Gradle to ensure all dependencies are installed.
   
   - For the **Python backend**:
     - Navigate to the `backend` folder and install the required Python dependencies:
       ```bash
       pip install -r requirements.txt
       ```

3. **Run the Backend**:
   - Start the Python Flask app:
     ```bash
     python app.py
     ```

4. **Run the Android App**:
   - Run the app on your Android device or emulator through Android Studio.

### Screenshots

- **Login Page**: Simple and clean login screen with registration functionality.
- **Dashboard**: After logging in, users can view their selected stock's historical data and predictions.
- **Prediction Graph**: A visual representation of the stock's historical data alongside future price predictions.

### Future Enhancements

- **Add More ML Models**: Implement more sophisticated prediction models (e.g., ARIMA, Prophet) for better accuracy.
- **Cloud Integration**: Migrate the backend to cloud platforms (e.g., AWS, Google Cloud) for scalable API handling.
- **News Integration**: Include a news section to provide real-time market sentiment and news affecting stock prices.
- **Notification System**: Push notifications to alert users of significant stock price changes or predictions.
- **Mobile App Enhancements**: Improve the mobile experience with features like dark mode and multi-stock tracking.

### Contributing

We welcome contributions to this project! If you encounter any issues or have suggestions for new features, feel free to fork the repository, make your changes, and submit a pull request.

### License

This project is licensed under the MIT License.

---

This description covers the core features of your mobile app, the technologies used, and provides an installation guide, while also leaving room for potential future improvements. Feel free to adjust the details based on your specific implementation!
