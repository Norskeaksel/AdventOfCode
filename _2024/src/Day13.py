import re
import numpy as np
from scipy.linalg import solve

c = 10000000000000
def parse_input_to_matrix(file_content):
    # Split the input into blocks using double newlines as delimiters
    blocks = file_content.strip().split("\n\n")
    ans = 0
    for block in blocks:
        A = np.zeros((2, 2))  # Coefficient matrix
        b = np.zeros(2)  # Constants vector

        # Extract the X and Y values for Button A, Button B, and Prize using regex
        match = re.search(
            r"Button A: X\+(\d+), Y\+(\d+)\n"
            r"Button B: X\+(\d+), Y\+(\d+)\n"
            r"Prize: X=(\d+), Y=(\d+)", block
        )

        if match:
            # Parse the extracted values
            A_x, A_y, B_x, B_y, P_x, P_y = map(int, match.groups())
            A[0,0] = A_x
            A[0,1] = B_x
            A[1,0] = A_y
            A[1,1] = B_y
            b[0] = P_x + c
            b[1] = P_y + c

            #print(f"A:{A}, b:{b}")
            x = np.linalg.lstsq(A,b)[0]
            #print(f"x:{x}")
            x1 = round(x[0])
            x2 = round(x[1])
            a_check = x1 * A_x + x2 * B_x == P_x + c
            b_check = x1 * A_y + x2 * B_y == P_y + c
            if a_check and b_check:
                ans+= 3*x1 + x2

    return ans


def read_file_and_parse_matrix(file_path):
    try:
        with open(file_path, 'r') as file:
            file_content = file.read()
        return parse_input_to_matrix(file_content)
    except FileNotFoundError:
        print(f"Error: The file '{file_path}' was not found.")
        return [], []


if __name__ == "__main__":
    print("ans:",read_file_and_parse_matrix("C:/Users/aksels/OneDrive - Statnett SF/AdventOfCode/_2024/inputFiles/Day12"))
