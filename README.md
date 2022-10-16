# To-do App for Interview

Time spent: 6 hours spent in total
# User Stories
- Develop an application has a feature that takes a user comment as input and
returns a JSON string containing information about it content:
- Mention: a way to mention a user. Always starts with an '@' and ends when
hitting a non-word character.
- Link: Any URLs contained in the message, along with the page's title.
For example, calling your function with the following inputs should result in the
corresponding return values.

Input: "@billgates do you know where is @elonmusk?"

Return (string):
{
"mentions": [
"billgates",
"elonmusk"
]
}

Input: "Olympics 2020 is happening; https://olympics.com/tokyo-2020/en/"

Return (string):
{
"links": [
{
"url": "https://olympics.com/tokyo-2020/en/",
"title": "Tokyo 2020 Olympics - Home of the Next Summer Games"
}
]
}

# The Challenge:
● Write your response in Java, leveraging the Android SDK as needed.

● Take your time and write quality, production-ready code:

● Your code should be clean with well-named functions and vars.

● A well-designed UI is a bonus.

● Writing tests is a must, tests should cover at least the happy cases.

● Be thorough and take the opportunity to show off your abilities.

● Using frameworks and libraries is acceptable.

● Deadline is 3 days after you receive this challenge.

● Push your work on Github and send us the link.


