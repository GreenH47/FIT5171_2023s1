from selenium import webdriver
import time
from pyflowchart import Flowchart
with open('quiz6.py') as f:
     code = f.read()

fc = Flowchart.from_code(code)
print(fc.flowchart())


# # Set up the webdriver
# driver = webdriver.Chrome() # Change this to the location of your chromedriver
# driver.get('https://flowchart.js.org/')
#
# # Wait for the page to load
# time.sleep(5)
#
# # Select the flowchart element and capture a screenshot
# flowchart = driver.find_element_by_id('flow')
# flowchart.screenshot('flowchart.png')
#
# # Close the browser
# driver.quit()
