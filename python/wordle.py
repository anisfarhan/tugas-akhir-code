import nltk
from nltk.corpus import words

# Download words corpus if not already downloaded
nltk.download('words')

# Get the list of English words
word_list = words.words()

# Filter words that match the "-ALER" pattern
pattern_words = [word.upper() for word in word_list if len(word) == 5 and word[-4:] == "aler"]

# Show first 20 matches for preview
# pattern_words = pattern_words[:20]

# print the words that match the pattern
for word in pattern_words:
    print(word)