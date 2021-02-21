import numpy as np
import tensorflow as tf 
import pandas as pd
# from sklearn.utils import shuffle
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense, InputLayer
from tensorflow.keras.layers.experimental import preprocessing

data = pd.read_csv("data.csv", names = ['hours','job','projects','level','rating', 'work_station', 'percent_earned', 'price'])

data['job'].replace({"UX designer": 1, "UI designer": 2, "logo designer": 3}, inplace=True)

factors = data.copy()
labels = factors.pop('price')
factors = np.array(factors)

#Train data
train_X = factors[:int(len(factors)*0.8)]
train_y = labels[:int(len(labels)*0.8)]
#Validation data
val_X = factors[int(len(factors)*0.8):int(len(factors)*0.9)]
val_y = labels[int(len(labels)*0.8):int(len(labels)*0.9)]
#test data
test_X = factors[int(len(factors)*0.9):]
test_y = labels[int(len(labels)*0.9):]

normalize = preprocessing.Normalization()
normalize.adapt(train_X)

model = Sequential([
  normalize,
  Dense(units=15, activation='tanh'),
  Dense(units=5, activation='tanh'),
  Dense(1)
])

model.compile(loss = tf.keras.losses.MeanSquaredLogarithmicError(),
              optimizer = tf.optimizers.Adam(),
              metrics=['kullback_leibler_divergence'])

model.fit(train_X,
    train_y,
    batch_size=64,
    epochs=1000,
    shuffle=True,
    validation_data=(val_X, val_y))

print("Evaluate on test data")
results = model.evaluate(test_X, test_y, batch_size=128)
print("test loss, test acc:", results)


tf.saved_model.save(model, "saved_model/my_model")

